/* 슬라이드쇼 */
$(document).ready(function(){
  loopShow();

  // 슬라이드 무한 반복
  setInterval(loopShow, 9000);

  // join All 누르면 전체 선택되는 거 구현
  // 체크박스 전체선택 및 전체해제
  $("#chk_all").click(function(){
    if($("#chk_all").is(":checked")) {
      $(".chk").prop("checked", true);
    } else {
      $(".chk").prop("checked", false);
    }
  });

  // 한개의 체크박스 선택 해제시 전체 선택 체크박스도 해제
  $(".chk").click(function(){
    if($("input[name='agree']:checked").length == 3) {
      $("#chk_all").prop("checked", true);
    } else {
      $("#chk_all").prop("checked", false);
    }
  });

  // Login 팝업 띄우기
  $("#loginbtn").click(function(){
    // 필수사항 입력하라고 문구 팝업 띄우기
    if($("input[name=uname]").val().length == 0){
      alert("아이디를 입력하여주세요");
      return
    }

    if($("input[name=psw]").val().length == 0){
      alert("비밀번호를 입력하여주세요");
      return
    }

    // 정상적 로그인 되었다는 팝업 띄우기
    alert('로그인이 완료되었습니다!');
    $("#id02").css("display","none");
  });


  // Join 팝업 띄우기
  $(".signupbtn").click(function(){
    // 필수사항 입력하라고 문구 팝업 띄우기
    if($("input[name=id]").val().length == 0){
      alert("아이디를 입력하여주세요");
      return
    }
    
    if($(".pws1").val().length == 0) {
      alert("패스워드를 입력하여주세요");
      return
    }

    if($(".pws2").val().length == 0) {
      alert("패스워드를 재입력을 입력하여주세요");
      return
    }

    if($("input[name=name]").val().length == 0){
      alert("이름을 입력하여주세요");
      return
    }

    if(!($(".chkneed1").is(":checked"))){
      alert("이용약관에 대한 필수 동의를 해주세요.");
      return
    }
    if(!($(".chkneed2").is(":checked"))){
      alert("개인정보 수집 및 이용에 대한 필수동의를 해주세요.");
      return
    }
    
    // 정상적으로 가입되었다는 팝업 띄우기
    alert('축하합니다~~!!!\n정상적으로 가입이 되었습니다.');
    $("#id02").css("display","none");

    
  });
});

// 슬라이드 자동 다음 페이지로 넘기기
function loopShow() {
  // currentSlide로 한 이유 
  // slideIndex 값도 함께 변경하기 위해
  currentSlide(1);
  setTimeout(currentSlide, 3000, 2);
  setTimeout(currentSlide, 6000, 3);
}

// 양 사이드에 있는 화살표시 움직이기 위해
function plusSlides(n) {
  showSlides(slideIndex += n);
}

// 아래의 동그란버튼 눌렀을때 페이지 옮기기
function currentSlide(n) {
  showSlides(slideIndex = n);
}

// 슬라이드 보이기
function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
}

// 모바일용 메뉴
function myFunction() {
  var x = document.getElementById("top_menus");
  
  if (x.style.display === "block") {
    x.style.display = "none";
  } else {
    x.style.display = "block";
  }
}

// 나머지 만들지 못한 소제목들은 준비중입니다 팝업창 띄우기
function prepar() {
  var x = document.getElementById('top_menus');

  alert('오픈예정! \n 준비중입니다.\n조금만 더 기다려주세요');
}