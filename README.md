# Judger-Main
OSS센터 Online Judge Main Server

온라인저지 API 기능들 정리

<<관리자>>
ContestController
* 컨테스트 등록
* 등록된 모든 컨테스트 조회
* 등록된 특정 컨테스트 조회
* 컨테스트 수정
* 컨테스트 삭제

ContestProblemRegistrationController
* 컨테스트에 문제 추가
* 컨테스트에 등록된 모든 문제들 조회

ContestApplicationController
* 컨테스트 신청 승인 
* 컨테스트를 신청한 유저의정보와 컨테스트정보 저장
* 컨테스트와 그 컨테스트를 신청한 사용자 정보 조회

ProblemController
* 서버에 문제 업로드
* 업로드된 모든 문제 정보 조회
* 업로드된 특정 문제 조회
* 문제 다운로드기능
* 서버에 등록된 문제 수정
* 서버에 등록된 문제 삭제
* 테스트케이스 등록

UserController
* 가입된 모든 유저들의 정보 조회

<<학생>>
QuestionController
* 질문 등록
* 질문 조회
* 질문 삭제

SubmitController
* 코드 제출(일반문제)
* 코드 제출(컨테스트)
* 코드 재재출(수정)
* 결과 조회
* 스코어보드 확인


<<교수>>
ClassController
* 강의실 생성
* 강의실 조회
* 강의실 삭제

Classroom-application Controller
* 강의실 user(학생) 등록
* 강의실 user(학생) 등록승인
* 강의실 user(학생) 조회

Classroom-homework-registration-Controller
* 강의실 과제 등록(진행중)
* 강의실 과제 조회(진행중)
* 강의실 과제 삭제(진행중)

(과제는 txt와 code로 분리할것)

+a
* 강의실 질의응답 클래스
* 강의실 시험 클래스
* 강의실 학생 성적 클래스
