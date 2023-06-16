<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, final1.*"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.text.SimpleDateFormat" %>
<jsp:useBean id="mb" scope="page" class="final1.MemberBean"/>
<jsp:useBean id="member" class="final1.Member"/>
<jsp:setProperty name ="member" property="*" />
<jsp:useBean id ="boardbean" scope="page" class="final1.BoardBean" />
<jsp:useBean id="board" class="final1.Board" />
<jsp:setProperty name="board" property="*" />

<%
	String action = request.getParameter("action");

	if (action.equals("search")) {
		ArrayList<Board> boards = boardbean.getBoardList();
		ArrayList<Board> result = new ArrayList<>();
		String searchWord = request.getParameter("word");
		
		for (Board b : boards) {
			if (b.getBoard_title().contains(searchWord)||b.getBoard_content().contains(searchWord)) {
				result.add(b);
			}
		}
		
		request.setAttribute("boards", result);
		request.setAttribute("search", true);
		pageContext.forward("board_list.jsp?pageNum=1");
	}

	if (action.equals("list")) {
		ArrayList<Board> boards = boardbean.getBoardList();
		ArrayList<Board> result = new ArrayList<>();
		int pageNum = Integer.parseInt(request.getParameter("pageNum")) - 1;	
		
		if (boards.size() < 10) {
			result = boards;
		}
		else {
			for (int i = pageNum * 10; (i < boards.size()) && (i < (pageNum * 10 + 10)); i++) {
				result.add(boards.get(i));
			}
		}
		
		request.setAttribute("search", false);
		request.setAttribute("boards", result);
		pageContext.forward("board_list.jsp");
	}
	
	if (action.equals("login")) {
		response.sendRedirect("login.jsp");
	}
	
	if (action.equals("join")) {
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		String m_name = request.getParameter("m_name");

		if (!m_id.equals("")) {
			if (!mb.checkIdValidation(m_id)) {
				out.println("<script>alert('이미 존재하는 아이디 입니다.');history.go(-1);</script>");
			}
			else {
				if (mb.insertMember(member)) {
					response.sendRedirect("board_control.jsp?action=login");
				} else {
					pageContext.forward("login.jsp");
					throw new Exception("회원가입 오류");
				}
			}
		}
		else {
			out.println("<script>alert('아이디를 입력해주세요.');history.go(-1);</script>");
		}
	}
	
	if (action.equals("loginProc")) {
		if (member.getM_id() == null) {
			out.println("<script>alert('아이디를 입력해주세요.');history.go(-1);</script>");
		}
		else if (member.getM_pw() == null) {
			out.println("<script>alert('비밀번호를 입력해주세요.');history.go(-1);</script>");
		}
		else {
			if (!mb.checkMember(member.getM_id(), member.getM_pw())) {
				session.setAttribute("s_id", member.getM_id());
				session.setAttribute("s_pw", member.getM_pw());
				session.setAttribute("s_name", mb.getUserName(member.getM_id()));
				response.sendRedirect("board_control.jsp?action=list&pageNum="+request.getParameter("pageNum"));
			} else {
				response.sendRedirect("board_control.jsp?action=login");
			}
		}
	}
	
	if (action.equals("logOut")) {
		session.removeAttribute("s_id");
		response.sendRedirect("board_control.jsp?action=login");
	}
	
	if (action.equals("insertBoard")) {
		if (boardbean.insertBoard(board)) {
			response.sendRedirect("board_control.jsp?action=list&pageNum=1");
		}
		else {
			throw new Exception("게시글 작성 오류");
		}
	}
	
	if (action.equals("detail")) {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		if (boardbean.getBoard(board_num) != null) {
			Board boardData = boardbean.getBoard(board_num);
			request.setAttribute("board", boardData);
			pageContext.forward("board_detail.jsp");
		} else {
			throw new Exception("게시글 조회 오류");
		}
	}
	
	if (action.equals("delete")) {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		if (!request.getParameter("conResult").equals("true")) {
			out.println("<script>history.go(-1);</script>");
		}
		else if (session.getAttribute("s_id").equals("admin")) {
			if (boardbean.deleteBoard(board_num)) {
				response.sendRedirect("board_control.jsp?action=list&pageNum=1");
			} else {
				throw new Exception("DB 삭제 오류");
			}
		}
		else if (!request.getParameter("pw").equals(boardbean.getBoard(board_num).getBoard_pw())) {
			out.println("<script>alert('비밀번호가 틀렸습니다.');history.go(-1);</script>");
		}
		else {
			if (boardbean.deleteBoard(board_num)) {
				response.sendRedirect("board_control.jsp?action=list&pageNum=1");
			} else {
				throw new Exception("DB 삭제 오류");
			}
		}
	}
	
	if (action.equals("update")) {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		if (session.getAttribute("s_id").equals("admin")) {
			if (boardbean.getBoard(board_num) != null) {
				Board boardData = boardbean.getBoard(board_num);
				request.setAttribute("board", boardData);
				pageContext.forward("board_update.jsp");
			} else {
				throw new Exception("DB 수정 오류");
			}
		}
		else if (!request.getParameter("pw").equals(boardbean.getBoard(board_num).getBoard_pw())) {
			out.println("<script>alert('비밀번호가 틀렸습니다.');history.go(-1);</script>");
		}
		else {
			if (boardbean.getBoard(board_num) != null) {
				Board boardData = boardbean.getBoard(board_num);
				request.setAttribute("board", boardData);
				pageContext.forward("board_update.jsp");
			} else {
				throw new Exception("DB 수정 오류");
			}
		}
	}
	
	if (action.equals("updateProc")) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String today = sdf.format(date);
		board.setBoard_date(today);
		
		if (boardbean.updateBoard(board)) {
			response.sendRedirect("board_control.jsp?action=list&pageNum=1");
		} else {
			throw new Exception("DB 수정 오류");
		}
	}
	
	if (action.equals("memeberDelete")) {
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		String m_repw = request.getParameter("m_repw");
		
		if (!mb.checkIdValidation(m_id)) {
			if (!mb.checkMember(m_id, m_pw)) {
				if (m_pw.equals(m_repw)) {
					if (mb.deleteUser(m_id, m_pw)) {
						pageContext.forward("login.jsp");
					} else {
						throw new Exception("회원 탈퇴 실패");
					}
				}
				else {
					out.println("<script>alert('비밀번호가 일치하지 않습니다.');history.go(-1);</script>");
				}
			} else {
				out.println("<script>alert('회원 정보가 일치하지 않습니다.');history.go(-1);</script>");
			}
		} else {
			out.println("<script>alert('아이디가 일치하지 않습니다.');history.go(-1);</script>");
		}
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>