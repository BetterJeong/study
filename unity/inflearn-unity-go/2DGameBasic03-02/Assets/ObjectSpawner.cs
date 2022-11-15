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
        /* 회전, 위치 변경
        for (int i = 0; i < 10; ++ i)
        {
            Vector3 position = new Vector3(-4.5f + i, 0, 0);
            Quaternion rotation = Quaternion.Euler(0, 0, i * 10);

            Instantiate(boxPrefab, position, rotation);
        }
        */


        /* 격자 무늬
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

        /* 랜덤 프리팹 생성
        for (int i = 0; i < 10; ++i)
        {
            int index = Random.Range(0, prefabArray.Length);
            Vector3 position = new Vector3(-4.5f + i, 0, 0);

            Instantiate(prefabArray[index], position, Quaternion.identity);
        }
        */

        /* 랜덤 위치 랜덤 프리팹
        for (int i = 0; i < objectSpawnCount; ++i)
        {
            int index = Random.Range(0, prefabArray.Length);
            float x = Random.Range(-7.5f, 7.5f);
            float y = Random.Range(-4.5f, 4.5f);
            Vector3 position = new Vector3(x, y, 0);

            Instantiate(prefabArray[index], position, Quaternion.identity);
        }
        */

        /* 스폰 포인트에서 스폰
        for (int i = 0; i < objectSpawnCount; ++i)
        {
            int prefabIndex = Random.Range(0, prefabArray.Length);
            int spawnIndex = Random.Range(0, spawnPointArray.Length);

            Vector3 position = spawnPointArray[spawnIndex].position;
            GameObject clone = Instantiate(prefabArray[prefabIndex], position, Quaternion.identity);
        }
        */

        /* 스폰 포인트에서 스폰하고 이동
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
        // 일정 개수만 생성 가능하게
        if (currentObjectCount + 1 > objectSpawnCount)
        {
            return;
        }

        // 원하는 시간마다 오브젝트 생성을 위한 시간 변수 연산
        objectSpawnTime += Time.deltaTime;

        // 0.5초에 한 번씩 실행
        if (objectSpawnTime >= 0.5f)
        {
            int prefabIndex = Random.Range(0, prefabArray.Length);
            int spawnIndex = Random.Range(0, spawnPointArray.Length);

            Vector3 position = spawnPointArray[spawnIndex].position;
            GameObject clone = Instantiate(prefabArray[prefabIndex], position, Quaternion.identity);

            Vector3 moveDirection = (spawnIndex == 0 ? Vector3.right : Vector3.left);
            clone.GetComponent<Movement2D>().Setup(moveDirection);

            currentObjectCount++;   // 현재 생성된 오브젝트 수
            objectSpawnTime = 0.0f; // 시간을 0으로 초기화
        }
    }
}
