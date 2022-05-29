# 토이 프로젝트 : 헬스 관리 서비스 만들기


## 추가구현(JPA,INTERCEPTOR,VALIDATION,SESSION)

데이터베이스 연결,로그인 기능 연결,검증기능 사용 



### 요구사항

 * 헬스 일정 등록하기   (구현)
 * 헬스 일정 조회하기   (구현)
 * 헬스 일정 완료하면 완료 체크 하기   (구현)
 * 헬스 일정 삭제하기 (구현)
 * 헬스 일정 수정하기  (구현)
 * 헬스 부위 구분하기 (어꺠,팔,가슴,등,하체)   (구현) 
 * 로그인 기능      (구현)  -interceptor , session 이용
 * 헬스 상품 구매 (구현)
 * 헬스 상품 취소 (구현)
 * 주문 생성, 취소  (구현)
 * 검증 이용 validation
 
 ### 데이터   (구현)
  #### 도메인
  * 상품
  * 헬스
  * 회원
  * 주문
  #### 도메인 관계

  * 회원-주문 일대다 관계 
  * 상품-주문 다대다 관계 (orderitem 클래스 이용->일대다 관계로 바꿈)
  * 회원-헬스 일대다 관계
 


https://user-images.githubusercontent.com/91003734/159005983-5ae236f2-6f37-4d4f-8878-5b77e6aa7544.mp4




    

