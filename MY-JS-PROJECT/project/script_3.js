// script.js
const KOFIC_API_KEY = '7640c070dfcd4f520a66fa46063f74dd'; // 여기에 발급받은 KOFIC API 키를 입력하세요.

document.addEventListener('DOMContentLoaded', () => {
    // DOM 요소 캐싱
    const boxOfficeDateInput = document.getElementById('boxOfficeDate');
    const searchButton = document.getElementById('searchButton');
    const movieRankingsList = document.getElementById('movieRankings');
    const movieDetailDiv = document.getElementById('movieDetail');

    // 초기 날짜 설정: 어제 날짜로 기본값 설정
    const yesterday = new Date();
    yesterday.setDate(yesterday.getDate() - 1);
    const formattedYesterday = yesterday.toISOString().split('T')[0];
    boxOfficeDateInput.value = formattedYesterday;

    // 페이지 로드 시 어제 날짜의 박스오피스 데이터를 불러옵니다.
    getDailyBoxOffice(formattedYesterday.replace(/-/g, ''));

    // '확인' 버튼 클릭 이벤트 리스너
    searchButton.addEventListener('click', () => {
        const selectedDate = boxOfficeDateInput.value; // YYYY-MM-DD 형식
        const apiDate = selectedDate.replace(/-/g, ''); // YYYYMMDD 형식으로 변환
        getDailyBoxOffice(apiDate); // 일별 박스오피스 데이터 조회
    });

    async function getDailyBoxOffice(targetDate) {
        // 로딩 메시지 표시 및 상세 정보 초기화
        movieRankingsList.innerHTML = '<li class="loading">박스오피스 데이터를 불러오는 중...</li>';
        movieDetailDiv.innerHTML = '<p>영화를 클릭하면 상세 정보가 표시됩니다.</p>';

        const url = `http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=${KOFIC_API_KEY}&targetDt=${targetDate}`;

        try {
            const response = await fetch(url);
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            const data = await response.json();

            // API 응답에서 박스오피스 목록 확인
            if (data.boxOfficeResult && data.boxOfficeResult.dailyBoxOfficeList) {
                displayBoxOfficeRankings(data.boxOfficeResult.dailyBoxOfficeList);
            } else {
                movieRankingsList.innerHTML = '<li>해당 날짜의 박스오피스 정보가 없습니다.</li>';
            }
        } catch (error) {
            console.error('Error fetching daily box office:', error);
            movieRankingsList.innerHTML = `<li style="color: red;">데이터를 불러오는데 실패했습니다. API 키를 확인하거나 나중에 다시 시도해주세요. (${error.message})</li>`;
        }
    }

    function displayBoxOfficeRankings(movies) {
        movieRankingsList.innerHTML = ''; // 기존 목록 초기화

        if (movies && movies.length > 0) {
            movies.forEach(movie => {
                const listItem = document.createElement('li');

                // 순위 변동 텍스트 및 클래스 생성
                let rankChangeClass = 'no-change';
                let rankChangeText = '';
                const rankInten = parseInt(movie.rankInten);

                if (movie.rankOldAndNew === 'NEW') {
                    rankChangeText = '(신규)';
                    rankChangeClass = 'new';
                } else if (rankInten > 0) {
                    rankChangeText = `(▲${rankInten})`;
                    rankChangeClass = 'up';
                } else if (rankInten < 0) {
                    rankChangeText = `(▼${Math.abs(rankInten)})`;
                    rankChangeClass = 'down';
                } else {
                    rankChangeText = '(-0)'; // 변화 없음
                }

                listItem.innerHTML = `
                    <span class="rank">${movie.rank}위</span>
                    <a href="#" data-movie-cd="${movie.movieCd}" data-movie-name="${movie.movieNm}">${movie.movieNm}</a>
                    <span class="change ${rankChangeClass}">${rankChangeText}</span>
                `;
                movieRankingsList.appendChild(listItem);
            });

            // 영화 제목 클릭 이벤트 리스너 추가
            movieRankingsList.querySelectorAll('a').forEach(link => {
                link.addEventListener('click', (e) => {
                    e.preventDefault(); // 기본 링크 동작 방지
                    const movieCode = e.target.dataset.movieCd;
                    const movieName = e.target.dataset.movieName;
                    getMovieDetail(movieCode, movieName);
                });
            });
        } else {
            movieRankingsList.innerHTML = '<li>해당 날짜의 박스오피스 정보가 없습니다.</li>';
        }
    }

    /**
     * 영화 상세 정보를 가져와 화면에 표시하는 비동기 함수.
     * @param {string} movieCode 영화 고유 코드 (KOBIS movieCd)
     * @param {string} movieName 영화 제목 (표시용)
     */
    async function getMovieDetail(movieCode, movieName) {
        movieDetailDiv.innerHTML = '<p class="loading">영화 상세 정보를 불러오는 중...</p>';

        const url = `http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=${KOFIC_API_KEY}&movieCd=${movieCode}`;

        try {
            const response = await fetch(url);
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            const data = await response.json();

            if (data.movieInfoResult && data.movieInfoResult.movieInfo) {
                displayMovieDetail(data.movieInfoResult.movieInfo);
            } else {
                movieDetailDiv.innerHTML = '<p>선택된 영화의 상세 정보가 없습니다.</p>';
            }
        } catch (error) {
            console.error('Error fetching movie detail:', error);
            movieDetailDiv.innerHTML = `<p style="color: red;">영화 상세 정보를 불러오는데 실패했습니다. (${error.message})</p>`;
        }
    }

    /**
     * 영화 상세 정보를 HTML로 구성하여 화면에 표시하는 함수.
     * @param {Object} movieInfo KOBIS 영화 상세 정보 객체
     */
    function displayMovieDetail(movieInfo) {
        if (movieInfo) {
            const genres = movieInfo.genres.map(g => g.genreNm).join(', ') || '정보 없음';
            const directors = movieInfo.directors.map(d => d.peopleNm).join(', ') || '정보 없음';
            const actors = movieInfo.actors.map(a => a.peopleNm).join(', ') || '정보 없음';
            const runningTime = movieInfo.showTm ? `${movieInfo.showTm}분` : '정보 없음';
            const movieNameEng = movieInfo.movieNmEn || '정보 없음';

            movieDetailDiv.innerHTML = `
                <p><strong>영화제목:</strong> ${movieInfo.movieNm}</p>
                <p><strong>영어제목:</strong> ${movieNameEng}</p>
                <p><strong>상영시간:</strong> ${runningTime}</p>
                <p><strong>감독:</strong> ${directors}</p>
                <p><strong>출연배우:</strong> ${actors}</p>
                <p><strong>장르:</strong> ${genres}</p>
            `;
        } else {
            movieDetailDiv.innerHTML = '<p>선택된 영화의 상세 정보가 없습니다.</p>';
        }
    }
});