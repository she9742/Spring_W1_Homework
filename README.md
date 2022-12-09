# Spring_W1_개인 과제


## <서비스 완성 요구사항>

1. 아래의 요구사항을 기반으로 Use Case 그리기
   
   <img width="422" alt="스크린샷 2022-12-08 오후 1 55 39" src="https://user-images.githubusercontent.com/117059217/206360251-0c0bb7bd-0adb-461f-b3e6-c3781963e4a1.png">

    
2. 전체 게시글 목록 조회 API
    - 제목, 작성자명, 작성 내용, 작성 날짜를 조회하기
    - 작성 날짜 기준 내림차순으로 정렬하기
3. 게시글 작성 API
    - 제목, 작성자명, 비밀번호, 작성 내용을 저장하고
    - 저장된 게시글을 Client 로 반환하기
4. 선택한 게시글 조회 API
    - 선택한 게시글의 제목, 작성자명, 작성 날짜, 작성 내용을 조회하기 
    (검색 기능이 아닙니다. 간단한 게시글 조회만 구현해주세요.)
5. 선택한 게시글 수정 API
    - 수정을 요청할 때 수정할 데이터와 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인 한 후
    - 제목, 작성자명, 작성 내용을 수정하고 수정된 게시글을 Client 로 반환하기
6. 선택한 게시글 삭제 API
    - 삭제를 요청할 때 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인 한 후
    - 선택한 게시글을 삭제하고 Client 로 성공했다는 표시 반환하기





 ## <API 명세서>

| **Method** |       **URL**      |                                 **Request**                                 |                                                                                                                                                                                                                                                                                         **Response**                                                                                                                                                                                                                                                                                         |
|:----------:|:------------------:|:---------------------------------------------------------------------------:|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
|     GET    |    /api/messages   |                                      -                                      | {  <br/>"createdAt": "2022-12-08T10:20:07.384",<br/> "modifiedAt": "2022-12-08T10:20:07.384",<br/> "id": 3,<br/> "title": "테스트 즁~~",<br/> "username": "포뇨포뇨", <br/>"password": "1234",<br/> "contents": "먼저 수정을 해봅시다!" <br/>},<br/> { <br/>"createdAt": "2022-12-08T10:19:41.215",<br/> "modifiedAt": "2022-12-08T10:19:41.215", <br/>"id": 2, <br/>"title": "고양이", <br/>"username": "손순애",<br/> "password": "12345", <br/>"contents": "우리집 고양이"<br/> }, <br/>{ <br/>"createdAt": "2022-12-08T10:19:25.102", <br/>"modifiedAt": "2022-12-08T10:19:25.102",<br/> "id": 1, <br/>"title": "강아지", <br/>"username": "몽심랑빵귬",<br/> "password": "12345", <br/>"contents": "우리집 강아지" <br/>} |
|    Post    |    /api/messages   | { <br/> "title": "이름", "username": "닉네임", "contents": "내용", "password": "비밀번호"<br/> } |                                                                                                                                                                                             { <br/>"createdAt": "2022-12-08T10:20:07.384",<br/> "modifiedAt": "2022-12-08T10:20:07.384",<br/> "id": 3,<br/> "title": "테스트 즁~~", <br/>"username": "포뇨포뇨",<br/> "password": "1234", <br/>"contents": "먼저 수정을 해봅시다!"<br/> }                                                                                                                                                                                            |
|     GET    | /api/messages/{id} |                           -                           |                                                                                                                                                                                                  { <br/>"createdAt": "2022-12-08T10:19:25.102",<br/> "modifiedAt": "2022-12-08T10:19:25.102", <br/>"id": 1, <br/>"title": "강아지", <br/>"username": "몽심랑빵귬", <br/>"password": "12345",<br/> "contents": "우리집 강아지" <br/>}                                                                                                                                                                                                 |
|     PUT    | /api/messages/{id} |            {    <br/> "password": "비밀번호",     "contents": "수정할 내용"<br/> }             |                                                                                                                                                                                         { <br/>"createdAt": "2022-12-08T10:20:07.384",<br/> "modifiedAt": "2022-12-08T10:23:22.933",<br/> "id": 3,<br/> "title": "테스트 즁~~",<br/> "username": "포뇨포뇨",<br/> "password": "1234", <br/>"contents": "수정 완료! 이제 삭제합시다!!"<br/> }                                                                                                                                                                                         |
| DELETE     | /api/messages/{id} |                           { <br/>"password": "비밀번호"<br/> }                            |                                                                                                                                                                                                                                                                                         삭제되었습니다.                                                                                                                                                                                                                                                                                      |
