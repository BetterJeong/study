using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour
{
    private Animator animator;

    private void Awake()
    {
        animator = GetComponent<Animator>();
    }

    private void Update()
    {
       if (Input.GetKeyDown(KeyCode.Space))
        {
            // 트리거 체크(활성화)
            animator.SetTrigger("isDie");
        }
    }

    public void OnDieEvent()
    {
        Debug.Log("End of Die Animation");
    }
}
