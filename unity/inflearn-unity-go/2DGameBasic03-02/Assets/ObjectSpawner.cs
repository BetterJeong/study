using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ObjectSpawner: MonoBehaviour
{
    // [SerializeField]
    // private GameObject boxPrefab;
    [SerializeField]
    private int objectSpawnCount = 30;
    [SerializeField]
    private GameObject[] prefabArray;
    [SerializeField]
    private Transform[] spawnPointArray;
    private int currentObjectCount = 0;
    private float objectSpawnTime = 0.0f;

    private void Awake()
    {
        /* ȸ��, ��ġ ����
        for (int i = 0; i < 10; ++ i)
        {
            Vector3 position = new Vector3(-4.5f + i, 0, 0);
            Quaternion rotation = Quaternion.Euler(0, 0, i * 10);

            Instantiate(boxPrefab, position, rotation);
        }
        */


        /* ���� ����
        for (int y = 0; y < 10; ++ y)
        {
            for (int x = 0; x < 10; ++ x)
            {
                if ( x == y || x + y == 9)
                {
                    continue;
                }
                Vector3 position = new Vector3(-4.5f + x, 4.5f - y, 0);
                Instantiate(boxPrefab, position, Quaternion.identity);
            }
        }
        */

        /* ���� ������ ����
        for (int i = 0; i < 10; ++i)
        {
            int index = Random.Range(0, prefabArray.Length);
            Vector3 position = new Vector3(-4.5f + i, 0, 0);

            Instantiate(prefabArray[index], position, Quaternion.identity);
        }
        */

        /* ���� ��ġ ���� ������
        for (int i = 0; i < objectSpawnCount; ++i)
        {
            int index = Random.Range(0, prefabArray.Length);
            float x = Random.Range(-7.5f, 7.5f);
            float y = Random.Range(-4.5f, 4.5f);
            Vector3 position = new Vector3(x, y, 0);

            Instantiate(prefabArray[index], position, Quaternion.identity);
        }
        */

        /* ���� ����Ʈ���� ����
        for (int i = 0; i < objectSpawnCount; ++i)
        {
            int prefabIndex = Random.Range(0, prefabArray.Length);
            int spawnIndex = Random.Range(0, spawnPointArray.Length);

            Vector3 position = spawnPointArray[spawnIndex].position;
            GameObject clone = Instantiate(prefabArray[prefabIndex], position, Quaternion.identity);
        }
        */

        /* ���� ����Ʈ���� �����ϰ� �̵�
        for (int i = 0; i < objectSpawnCount; ++i)
        {
            int prefabIndex = Random.Range(0, prefabArray.Length);
            int spawnIndex = Random.Range(0, spawnPointArray.Length);

            Vector3 position = spawnPointArray[spawnIndex].position;
            GameObject clone = Instantiate(prefabArray[prefabIndex], position, Quaternion.identity);

            Vector3 moveDirection = (spawnIndex == 0 ? Vector3.right : Vector3.left);
            clone.GetComponent<Movement2D>().Setup(moveDirection);
        }
        */
    }

    private void Update()
    {
        // ���� ������ ���� �����ϰ�
        if (currentObjectCount + 1 > objectSpawnCount)
        {
            return;
        }

        // ���ϴ� �ð����� ������Ʈ ������ ���� �ð� ���� ����
        objectSpawnTime += Time.deltaTime;

        // 0.5�ʿ� �� ���� ����
        if (objectSpawnTime >= 0.5f)
        {
            int prefabIndex = Random.Range(0, prefabArray.Length);
            int spawnIndex = Random.Range(0, spawnPointArray.Length);

            Vector3 position = spawnPointArray[spawnIndex].position;
            GameObject clone = Instantiate(prefabArray[prefabIndex], position, Quaternion.identity);

            Vector3 moveDirection = (spawnIndex == 0 ? Vector3.right : Vector3.left);
            clone.GetComponent<Movement2D>().Setup(moveDirection);

            currentObjectCount++;   // ���� ������ ������Ʈ ��
            objectSpawnTime = 0.0f; // �ð��� 0���� �ʱ�ȭ
        }
    }
}
