using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ObjectSpawner : MonoBehaviour
{
    [SerializeField]
    private GameObject boxPrefab;

    private void Awake()
    {
        Instantiate(boxPrefab); // 박스 생성
        Instantiate(boxPrefab, new Vector3(3, 3, 0), Quaternion.identity);
        // Instantiate(GameObject original, Vector3 position, Quaternion rotation);
        Quaternion rotation = Quaternion.Euler(0, 0, 45);
        Instantiate(boxPrefab, new Vector3(2, 1, 0), rotation);

        GameObject clone = Instantiate(boxPrefab, Vector3.zero, rotation);
        // GameObject clone = Instantiate(GameObject original, Vector3 position, Quaternion rotation);

        clone.name = "Box001";  // 오브젝트 이름 변경
        clone.GetComponent<SpriteRenderer>().color = Color.black;   // 오브젝트 색상 변경
        clone.transform.position = new Vector3(2, 1, 0);    // 오브젝트 위치 변경
        clone.transform.localScale = new Vector3(3, 2, 1);  // 오브젝트 크기 변경
    }
}
