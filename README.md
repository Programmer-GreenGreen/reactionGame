# reactionGame

| column name | type        | ex            |
|-------------|-------------|---------------|
| idx         | int         | PK,AI         |
| date        | datetime    | java NOW()    |
| name        | varchar(20) | no duplicates |
| ratetime    | int         | game result   |

- [ ] 랭킹을 어떻게 구할 것인가?
- [ ] 랭킹 칼럼을 만들 것인가?
- [x] REST API -> 전체 조회
- [x] REST API -> 부분 조회
- [x] REST API -> 부분 입력
- [x] REST API -> 부분 수정
- [x] REST API -> 부분 삭제 (update X delete)
- [ ] 갱신 기준 -> 하루 , 하루가 지나면 전체 삭제?
- [ ] 닉네임 중복 불가
