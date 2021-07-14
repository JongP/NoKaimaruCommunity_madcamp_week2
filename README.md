# NO KAIMARU : Community

### 프로젝트 한 줄 소개
> 어은동 맛집들에 대한 정보와 리뷰를 공유할 수 있는 커뮤니티 앱.

### 팀원 소개
> 김현수, 박종회  

### 다운로드 링크
> [Click Here](https://drive.google.com/file/d/1U405AnZg8mo9yUkzyT1M2L6q17bdciW0/view?usp=sharing)
---  

### 프로젝트 상세 설명

클라이언트는 안드로이드 스튜디오에서 자바를 사용하였다.
서버는 node js에서 mongoDB를 사용하였다.

#### MainActivity
<img src="https://user-images.githubusercontent.com/61833862/125467446-d961f6e8-30cd-4990-8697-421479d746b1.jpg" width="200" height="400">

> SplashTheme 를 만든 후 MainActivity의 theme로 설정해 앱 실행 시 로고가 뜬다.
>
> TabLayout을 이용하고, ViewPager의 각 페이지와 연동했다.
> 
> MainActivity 이전에 LoginAcitivty를 통해 구글 SDK로 로그인 정보를 받고, 서버에 UserModel에 user 정보를 등록한다. 


#### TAB1 - RESTAURANT

<img src="https://user-images.githubusercontent.com/61833862/125465488-4b966320-fd5a-490c-888e-bd1c96222c4e.jpg" width="200"> &nbsp;&nbsp;&nbsp;

> + Design
> 
> DB에 저장된 20개 식당의 이름, 평균 별점을 서버를 통해 불러와 리스트 형식으로 보여준다. 
> 
> 식당의 카테고리 별로 리스트를 접었다 펼 수 있다. 
> 
> 식당을 클릭하면 식당에 대한 상세 페이지가 뜬다. (RestaurantActivity 참고) 

> + Implementation
> 
> retrofit을 사용하여 DB로부터 식당들의 이름과 평균 별점, 카테고리, 식당의 고유 ID를 불러온다.
> 
> Expandable Recycler View 를 사용했다.
> 
> 섞여있는 식당들을 카테고리별로 분류하여 Expandable Recycler View의 header에 맞게 배치하였다.  
> 
> Default 화면은 Header가 전부 펼쳐져 보인다.
> 
> 식당 이름을 클릭하면 식당의 고유 ID를 intent를 통해 넘겨주고 RestaurantActivity를 실행한다.
> 
> favorite을 클릭하면 user ID로 UserModel에서 유저를 쿼리하고, user 안의 favorites이라는 배열에 중복 체크 후 추가한다.


#### RestaurantActivity

<img src="https://user-images.githubusercontent.com/61833862/125465855-fa34794e-e3fc-416a-b2e1-598cf5b4e8eb.jpg" width="200">

> + Design
>
> 식당의 커버 이미지가 위쪽에 뜨고 아래쪽엔 식당에 대한 여러가지 정보와 버튼들이 있다.
> 
> 식당 이름과 전화번호, 카테고리, 평균 별점에 대한 정보를 보여준다. 전화번호를 클릭하면 전화 다이얼로 연결된다.
> 
> FAVORITE button : 식당을 즐겨찾기 할 수 있다.
> 
> SEE REVIEW button : 이 식당에 남겨진 모든 리뷰들을 모아 볼 수 있다. (SeeReviewActivity 참고)
> 
> WRITE REVIEW button : 이 식당에 리뷰를 작성할 수 있다. (WritePostActivity 참고)
> 
> 위에서 아래로 스와이프 하면 새로고침 된다. 별점이 업데이트 되는 것을 볼 수 있다. 

> + Implementation
> 
> retrofit을 이용해서 DB로부터 식당의 커버 사진을 비롯한 정보들을 불러온다. 
>
> network thread와 retrofit을 조합해서 사용하는데 실패해서, Restrict Mode를 사용하여 main thread에서 사진을 불러온다.


#### SeeReviewActivity

<img src="https://user-images.githubusercontent.com/61833862/125466029-4f14872c-1159-42d3-a795-cbd5af6642ed.jpg" width="200">

> + Design
> 
> TAB2랑 같은 아이템들이 리사이클러뷰로 보인다.
> 
> 해당 식당에 남겨진 모든 리뷰들을 모아 볼 수 있다.

> + Implementation
> 
> intent를 통해 넘겨받은 리뷰 포스트의 고유 ID를 이용해서 리뷰들을 모아온다.
> 
> mongoDB에서 레스토랑의 id로 PostModel을 쿼리하여 보내준다.

#### WritePostActivity

<img src="https://user-images.githubusercontent.com/61833862/125466138-1249529d-33e7-4c2c-8f49-2d28721bfbc9.jpg" width="200"> &nbsp;&nbsp;&nbsp; <img src="https://user-images.githubusercontent.com/61833862/125466255-f71100e0-4455-4d51-92d9-99927e22b65b.jpg" width="200">

> + Design
> 이미지와 리뷰 제목, 리뷰 본문, 별점을 업로드 할 수 있다.
> 
> 위의 항목 중 어느 하나라도 빠뜨리면 업로드할 수 없고 경고 문구가 뜬다.

> + Implementation
> 
> DB의 PostModel에 새로운 다큐먼트를 만들고 저장한다. Multipart를 이용해 사진을 전송하고 서버에 byte stream으로 jpeg파일을 저장한다.


#### TAB2 - REVIEWS

<img src="https://user-images.githubusercontent.com/61833862/125466854-9e3f5c04-4208-4e05-9d74-4516ea6831f7.jpg" width="200">

> + Design
> 모든 식당 리뷰를 한 번에 모아서 볼 수 있는 탭이다. 
> 
> 별점과 식당, 리뷰의 제목과 작성자 닉네임이 묶여서 리스트 형식으로 보인다.
>
> 리뷰 자세히 보기 버튼을 누르면 리뷰에 대한 상세 정보가 뜬다. (DetailPostActivity 참고)
> 
> 자동으로 새로고침 되어 새로 등록된 리뷰가 있다면 보인다.

> + Implementation
> retrofit을 이용하여 서버를 통해 DB에 있는 리뷰 정보를 받아온다.
> 
> RecyclerView와 Cardview를 사용했다.
>
> 각 포스트의 고유 ID, 작성자 고유 ID, 식당 고유 ID, 별점, 제목, 본문, 식당 이름, 작성자 닉네임을 받아온다.
>
> 리뷰 자세히 보기 버튼을 누르면 포스트의 고유 ID를 intent.putExtra로 넘기고 DatailPostActivity를 실행한다.


#### DatailPostActivity

<img src="https://user-images.githubusercontent.com/61833862/125466496-a86094d5-9c9d-43df-99e8-ac03480cc6d8.jpg" width="200">  &nbsp;&nbsp;&nbsp; <img src="https://user-images.githubusercontent.com/61833862/125466731-936a77bd-0580-47ca-89f4-58bfb122cb20.jpg" width="200"> &nbsp;&nbsp;&nbsp; <img src="https://user-images.githubusercontent.com/61833862/125466585-85ae834b-7aa8-417d-b170-a794b436bec1.jpg" width="200">

> + Design
>
> 해당 리뷰가 남겨진 식당과 리뷰에 첨부된 사진, 제목, 본문, 별점이 보인다.
> 
> 좋아요를 남길 수 있고 취소도 할 수 있다.

> + Implementation
> 
> DB에서 사진의 byte stream을 넘겨준다. 안드로이드에서 byte stream을 bitmap으로 decode해서 image view에서 보여준다.


#### TAB3 - MY PAGE

<img src="https://user-images.githubusercontent.com/61833862/125464538-f958f4ee-5495-49d0-9e82-b4ff205abfba.jpg"  width="200" height="400">


+ Design
> 현재 로그인 된 유저의 이름, 이메일, 프로필 사진이 뜬다. 
> 
> favorite 지정한 식당의 리스트를 볼 수 있다.
> 
> favorite 식당 리스트의 식당을 클릭하면 해당 식당의 상세 정보 페이지 (RestaurantActivity)로 이동한다.

+ Implementation
> 구글 SDK를 사용하여 구글 로그인을 한다.
> 
> 유저 ID를 이용해 retrofit을 통해 DB로부터 로그인한 유저가 favorite 표시한 식당 리스트를 불러온다.
>
> intent를 이용해 식당 이름을 클릭했을 때 RestaurantActivity로 넘어간다. 
>
> DB에서 UserModel의 favorites 배열에서 저장 되어있는, restID를 populate이라는 메소드로 RestModel로 복원해낸다. 이후 RestModel의 JSON Array를 클라인트로 전송한다.



