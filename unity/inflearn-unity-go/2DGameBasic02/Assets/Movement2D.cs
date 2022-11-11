using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Movement2D : MonoBehaviour
{
    private float moveSpeed = 5.0f; // 이동 속도
    private Rigidbody2D rigid2D; // 컴포넌트와 동일 타입 변수 생성

    private void Awake()
    {
        rigid2D = GetComponent<Rigidbody2D>();  // 컴포넌트 정보 얻어와서 변수에 저장
    }

    private void Update()
    {
        float x = Input.GetAxisRaw("Horizontal");   // 좌우 이동
        float y = Input.GetAxisRaw("Vertical");     // 위아래 이동

        // 컴포넌트 정보가 저장된 변수 사용
        // velocity: (방향 + 속도) 속력을 나타내는 변수
        // 기존 이동 코드 대신 Rigidbody2D 에 의해 이동 가능
        rigid2D.velocity = new Vector3(x, y, 0) * moveSpeed;
    }
}
