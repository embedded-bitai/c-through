<template>
  <div>
    <div id="map" class="map"></div>
  </div>
</template>
<script>
import router from '../../routes'
import axios from 'axios'
export default {
  name: 'Map',
  mounted() {
    axios.post("http://localhost:1234/sendpersonNum")
      .then(res => {
        res.data
      })
    window.kakao && window.kakao.maps
        ? this.addKakaoMapScript()
        : this.initMap();
  },
  methods: {
    addKakaoMapScript() {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
          "http:////dapi.kakao.com/v2/maps/sdk.js?appkey=aeb90d46ca50b2629ab2d7f26488cf71&libraries=services";
      document.head.appendChild(script);
    },
    initMap() {
      let infowindow = new kakao
          .maps
          .InfoWindow({zIndex: 1});
      let mapContainer = document.getElementById("map");
      let options = {
        center: new kakao
            .maps
            .LatLng(37.5704163, 126.983138),
        level: 3
      };
      //map에 지도를 생성
      let map = new kakao
          .maps
          .Map(mapContainer, options);
      //장소 검색 객체를 생성합니다.
      let ps = new kakao
          .maps
          .services
          .Places();
      ps.keywordSearch('종각 비트캠프', placesSearchCB);
      ps.keywordSearch('종로2가 카페', placesSearchCB);
      ps.keywordSearch('종각역 카페', placesSearchCB);
      // 키워드 검색 완료 시 호출되는 콜백함수 입니다
      function placesSearchCB(data, status, pagination) {
        if (status === kakao.maps.services.Status.OK) {
          // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해 LatLngBounds 객체에 좌표를 추가합니다
          let bounds = new kakao
              .maps
              .LatLngBounds();
          for (let i = 0; i < data.length; i++) {
            let a = Math.random() * 10 + 1
            displayMarker(data[i], a);
            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
          }
          // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
          map.setBounds(bounds);
        }
      }
      function displayMarker(place, a) {
        // 마커를 생성하고 지도에 표시합니다
        let imageSrc = ''
        if (a > 3 && a < 7) {
          imageSrc = require("@/assets/cafeImage/cafe1.png")
        } else if (a > 7) {
          imageSrc = require("@/assets/cafeImage/cafe3.png")
        } else {
          imageSrc = require("@/assets/cafeImage/cafe2.png")
        }
        console.log(a)
        let imageSize = new kakao.maps.Size(65, 65)
        let markerPositon = new kakao.maps.LatLng(place.y, place.x),
            markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize)
        let marker = new kakao.maps.Marker({
          image: markerImage,
          position: markerPositon
        });
        const place2 = place.place_name
        marker.setMap(map);
        // 인포윈도우를 생성하고 지도에 표시합니다
        // let content = '<div sytle="font-size:12px;">hi</div>' +
        //                 '<div style="padding:50px;font-size:12px;">' +
        //                 '<a href="https://www.naver.com" style="color:#ff0000" target="_blank">' +
        //                 place.place_name + '(체크)</div>'
        let content = '<div class ="overlaybox">' +
            '    <div class="boxtitle"></div>' +
            '    <div class="first">' +
            '        <div class="placeName text">' + place.place_name + '<br>' +
            '        <span style="font-size: 10px">' + place.address_name + '</span>' +
            '        </div>' +
            '    </div>' +
            '    <ul>' +
            '        <a id = "showPeople">' +
            '           <li>' +
            '            <span class="title">혼잡도</span>' +
            '           </li>' +
            '        </a>' +
            '        <a id = "txt2">' +
            '           <li>' +
            '               <span class="title">즐겨찾기</span>' +
            '           </li>' +
            '        </a>' +
            '        <a id = "showMenu">' +
            '           <li>' +
            '               <span class="title">주문</span>' +
            '           </li>' +
            '        </a>' +
            '    </ul>' +
            '</div>'
        kakao
            .maps
            .event
            .addListener(marker, 'click', function () {
              // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
              infowindow.setContent(content);
              infowindow.open(map, marker)
              let btn1 = document.getElementById("showMenu");
              let btn2 = document.getElementById("showPeople");
              btn1.onclick = function () {
                router.push({name: 'Menu', params: {'place': place.place_name}});
              }
              btn2.onclick = function () {
                window.open('http://localhost:1234/opencv/'+place2)
              }
            });
      }
    }
  }
};
</script>
<style>
.map {
  width: 100vw;
  height: 100vh;
}
.overlaybox {
  position: relative;
  width: auto;
  /*height: auto;*/
  background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/box_movie.png') no-repeat;
  padding: 15px 10px;
  opacity: 85%;
  border-radius: 5px;
}
.overlaybox li {
  list-style: none;
}
/* css main image*/
.overlaybox .first {
  position: relative;
  width: 247px;
  height: 136px;
  background: url('https://img.lovepik.com/photo/40155/7458.jpg_wh860.jpg');
  background-size: 247px 136px;
  margin-bottom: 8px;
}
.first .text {
  color: white;
  font-weight: bold;
}
.first .placeName {
  position: absolute;
  width: 100%;
  bottom: 0;
  background: rgba(0, 0, 0, 0.2);
  padding: 7px 15px;
  font-size: 14px;
}
.overlaybox ul {
  width: 247px;
}
.overlaybox li {
  position: relative;
  margin-bottom: 2px;
  background: #2b2d36;
  padding: 5px 10px;
  color: #aaabaf;
  line-height: 1;
}
.overlaybox li span {
  display: inline-block;
}
.overlaybox li .title {
  font-size: 13px;
}
.overlaybox li:hover {
  color: #fff;
  background: #d24545;
}
</style>
