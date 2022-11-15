using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour
{
    [SerializeField]
    private KeyCode keyCodeFire = KeyCode.Space;
    [SerializeField]
    private GameObject bulletPrefab;
    private float moveSpeed = 3.0f;
    private Vector3 lastMoveDiretion = Vector3.right;

    private void Update()
    {
        // �÷��̾� ������Ʈ �̵�
        float x = Input.GetAxisRaw("Horizontal");
        float y = Input.GetAxisRaw("Vertical");

        transform.position += new Vector3(x, y, 0) * moveSpeed * Time.deltaTime;

        // �������� �Էµ� ����Ű�� ������ �Ѿ��� �߻� �������� Ȱ��
        if (x != 0 || y != 0)
        {
            lastMoveDiretion = new Vector3(x, y, 0);
        }

        // �÷��̾� ������Ʈ �Ѿ� �߻�
        if (Input.GetKeyDown(keyCodeFire))
        {
            GameObject clone = Instantiate(bulletPrefab, transform.position, Quaternion.identity);
            clone.name = "Bullet";
            clone.transform.localScale = Vector3.one * 0.5f;
            clone.GetComponent<SpriteRenderer>().color = Color.red;

            clone.GetComponent<Movement2D>().Setup(lastMoveDiretion);
        }
    }
}