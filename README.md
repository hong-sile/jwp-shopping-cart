# jwp-shopping-cart

## 요구 기능 목록

- [x] 페이지 접속
    - [x] 상품 목록 페이지 연동
        - [x] "/" 로 접근하면 상품 목록 페이지(index.html)로 접근한다.
        - [x] 상품 조회 기능이 동작하게 만든다.
    - [x] 관리자 도구 페이지 연동
        - [x] "/admin" 으로 접근할 경우 관리자 도구 페이지(admin.html)로 접근한다.
        - [x] 상품 추가 기능이 동작하게 만든다.
        - [x] 상품 수정 기능이 동작하게 만든다.
        - [x] 상품 삭제 기능이 동작하게 만든다.

- [x] 상품에 대한 정보
    - [x] 상품 ID
    - [x] 상품 이름
    - [x] 상품 이미지(url)
    - [x] 상품 가격

- [x] 상품 관리 CRUD API
    - [x] 상품 생성
    - [x] 상품 목록 조회
    - [x] 상품 수정
    - [x] 상품 삭제

- [x] validate
    - [x] 가격 : 0이상인 정수
    - [x] 이름 : 255자까지
    - [x] imageUrl : 확장자 종류 validation(regex)

## 📚 API

### Product
| 기능 | Method | URL             |
|----|--------|-----------------|
| 생성 | POST   | /products       |
| 수정 | PUT    | /products/{id}  |
| 삭제 | DELETE | /products/{id}  |
