using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TriggerEvent : MonoBehaviour
{
    [SerializeField]
    private GameObject moveObject;
    [SerializeField]
    private Vector3 moveDirection;
    private float moveSpeed;

    private void Awake()
    {
        moveSpeed = 5.0f;
    }

    private void OnTriggerEnter2D(Collider2D collision)
    {
        // moveObject 의 색상 변경
        moveObject.GetComponent<SpriteRenderer>().color = Color.black;
    }

    private void OnTriggerStay2D(Collider2D collision)
    {
        // moveObject 를 moveDirection 방향으로 이동
        moveObject.transform.position += moveDirection * moveSpeed * Time.deltaTime;
    }

    private void OnTriggerExit2D(Collider2D collision)
    {
        // 오브젝트 색상 흰색으로 변경
        moveObject.GetComponent<SpriteRenderer>().color = Color.white;
        // 오브젝트 위치 변경
        moveObject.transform.position = new Vector3(0, 4, 0);
    }
}
