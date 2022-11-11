using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Movement2D : MonoBehaviour
{
    private float moveSpeed = 5.0f; // 이동 속도
    private Vector3 moveDirection = Vector3.zero;   // 이동 방향

    private void Update()
    {
        // 키를 누르면 바로 1 or -1
        // float value = Input.GetAxisRaw("단축키명");

        // 키를 누르고 있으면 0에서 1 or -1 로 서서히 증가
        // float value = Input.GetAxis("단축키명");

        float x = Input.GetAxisRaw("Horizontal");   // 좌우 이동
        // Negative: left, a    부정: -1
        // 대기: 0
        // Positive: right, d   긍정: +1
        
        float y = Input.GetAxisRaw("Vertical");     // 위아래 이동
        // Negative: down, s    부정: -1
        // 대기: 0
        // Positive: up, w   긍정: +1

        moveDirection = new Vector3(x, y, 0);
        // x: 왼쪽 키 누르면 -1, 오른쪽 키 누르면 1
        // y: 아래쪽 키 누르면 -1, 위쪽 키 누르면 1
        // 방향으로 사용

        transform.position += moveDirection * moveSpeed * Time.deltaTime;
    }
}
