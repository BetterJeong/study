using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Movement2D : MonoBehaviour
{
    [SerializeField]
    private float speed = 5.0f;
    [SerializeField]
    private float jumpForce = 8.0f;
    private Rigidbody2D rigid2D;
    [HideInInspector] // public 변수를 inspector 에 안 보이게 하기
    public bool isLongJump = false;

    // 바닥 판정, 점프 제어
    [SerializeField]
    private LayerMask groundLayer;  // 바닥 체크를 위한 충돌 레이어
    private CapsuleCollider2D capsuleCollider2D;    // 오브젝트의 충돌 범위 컴포넌트
    private bool isGrounded;    // 바닥 체크 (바닥에 닿아있으면 true)
    private Vector3 footPosition;   // 발의 위치

    // 점프 횟수 설정
    [SerializeField]
    private int maxJumpCount = 2;   // 최대 점프 횟수
    private int currentJumpCount = 0;   // 현재 가능 점프 횟수

    private void Awake()
    {
        rigid2D = GetComponent<Rigidbody2D>();
        capsuleCollider2D = GetComponent<CapsuleCollider2D>();
    }

    private void FixedUpdate()
    {
        // 플레이어 오브젝트 Collider2D의 min, center, max 위치 정보
        Bounds bounds = capsuleCollider2D.bounds;
        // 플레이어 발 위치 설정
        footPosition = new Vector2(bounds.center.x, bounds.min.y);
        // 플레이어 발 위치에 원 생성, 원이 바닥과 닿으면 isGrounded = true
        isGrounded = Physics2D.OverlapCircle(footPosition, 0.1f, groundLayer);

        // 플레이어 점프 횟수 조절
        // 땅에 닿아 있으면 점프 횟수 초기화
        if (isGrounded == true && rigid2D.velocity.y <= 0)
        {
            currentJumpCount = maxJumpCount;
        }

        // 중력 계수(gravityScale) 조절
        if (isLongJump && rigid2D.velocity.y > 0)
        { // 높은 점프: 계속 누르고 있으면
            rigid2D.gravityScale = 1.0f;
        }
        else
        { // 낮은 점프: 누르고 떼면
            rigid2D.gravityScale = 2.5f;
        }
    }

    private void OnDrawGizmos()
    {
        Gizmos.color = Color.blue;
        Gizmos.DrawSphere(footPosition, 0.1f);
    }

    public void Move(float x)
    {
        rigid2D.velocity = new Vector2(x * speed, rigid2D.velocity.y);
    }

    public void Jump()
    {
        // 점프 가능 횟수가 있을 때만 점프 가능
        if (currentJumpCount > 0)
        {
            rigid2D.velocity = Vector2.up * jumpForce;
            currentJumpCount--;
        }
    }
}
