
reset();

const msg = document.querySelector("#movieRankings");
const detail = document.getElementById("movieDetail");

const findbutton = document.getElementById("searchButton");
const resetbutton = document.getElementById("resetButton");
//어제 날짜를 기본값으로 설정하는 코드
const key = "6eea4b736d6059274da0215df4735b6a"; // 개인 키값넣기

findbutton.addEventListener("click", function () {
    const dateInput = document.querySelector("#boxOfficeDate").value;
    const targetDt = dateInput.replaceAll('-', '');
    getBoxOfficeByDate(targetDt)
});

resetbutton.addEventListener("click", function () {
    reset();
});

// 박스오피스 조회
function getBoxOfficeByDate(date) {
    const selectedDate = date;
    if (!selectedDate) {
        alert("날짜를 선택하세요.");
        return;
    }

    const boxOfficeUrl = `https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=6eea4b736d6059274da0215df4735b6a&targetDt=` + date;
    console.log(boxOfficeUrl);
    fetch(boxOfficeUrl)
        .then(res => res.json())
        .then(data => {
            const movies = data.boxOfficeResult.dailyBoxOfficeList;
            let str = "<ul>";

            movies.forEach((movie, i) => {
                let rankInten = movie.rankInten;
                let char = '-';
                if (rankInten > 0) {
                    char = '▲';
                }
                else if (rankInten < 0) {
                    char = '▼';
                }

                str += `<li class="movielist" data-moviecd="${movie.movieCd}">${i + 1}위(${char}${rankInten}): ${movie.movieNm}</li>`;
            });

            str += "</ul>";
            msg.innerHTML = str;

            // 이벤트 바인딩
            const listItems = document.querySelectorAll(".movielist");
            listItems.forEach(item => {
                item.addEventListener("click", () => {
                    const movieCd = item.dataset.moviecd;
                    show(movieCd);
                });

            });
        })
        .catch(err => console.error("박스오피스 조회 오류:", err));
}

//상세 정보 보여주기 (예시)
function show(movieCd) {
    const url = `https://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=${key}&movieCd=${movieCd}`;
    console.log(movieCd)
    console.log(url)
    fetch(url)
        .then(res => res.json())
        .then(data => {
            const info = data.movieInfoResult.movieInfo;
            let str = "<ul>";
            str += `<li>영화제목: ${info.movieNm}</li>`;
            str += `<li>영화영문명: ${info.movieNmEn}</li>`;
            str += `<li>감독: ${info.directors.map(d => d.peopleNm).join(", ")}</li>`;
            str += `<li>출연진: ${info.actors.slice(0, 5).map(a => a.peopleNm).join(", ")}</li>`;
            str += "</ul>";

            detail.innerHTML = str;
        })
        .catch(err => {
            detail.innerHTML = "<p>영화 정보를 불러오지 못했습니다.</p>";
            console.error(err);
        });
}

function reset() {
    const yesterday = new Date();
    yesterday.setDate(yesterday.getDate() - 1); // 어제로 설정

    // YYYY-MM-DD 형식으로 변환
    const formatted = yesterday.toISOString().split('T')[0];
    document.getElementById('boxOfficeDate').value = formatted;

    document.getElementById('movieRankings').innerHTML = '날짜를 선택하고 \'확인\' 버튼을 눌러주세요.';
    document.getElementById('movieDetail').innerHTML = '영화를 클릭하면 상세 정보가 표시됩니다.';
}