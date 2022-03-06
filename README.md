# 토이 프로젝트 : 헬스 관리 서비스 만들기

###요구사항
 *헬스 일정 등록하기
 *헬스 일정 조회하기
 *헬스 일정 완료하면 완료 체크 하기
 *헬스 일정 삭제하기
 
 *헬스 부위 구분하기 (어꺠,팔,가슴,등,하체)
 
 
 ###데이터
 
  *health 
    *(long) number
    *(string) datetime //날짜
    *(enum) health location //헬스 부위
    *(string) exercise //운동 이름
    *(int) set //세트 횟수
    *(int) count //세트당 횟수
  *health location
    *shoulder
    *arm
    *chest
    *back
    *lower body
    

