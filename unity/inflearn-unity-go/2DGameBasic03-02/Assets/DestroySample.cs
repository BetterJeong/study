using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class DestroySample : MonoBehaviour
{
    [SerializeField]
    private GameObject playerObject;

    private void Awake()
    {
        // ������Ʈ ����
        // Destroy(playerObject.GetComponent<PlayerController>());

        // playerObject ���� ������Ʈ ����
        // Destroy(playerObject);

        // ������Ʈ�� 2�� �ڿ� ����
        // Destroy(playerObject, 2.0f);
    }
}
