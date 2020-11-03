<template>
  <v-card color="basil" >
    <v-card-title class="text-center justify-center py-6">
      <h1 class="font-weight-bold display-3 basil--text">Menu</h1>
      <v-btn id="hoi">주문하기</v-btn>
    </v-card-title>
    <v-tabs
        v-model="tab"
        background-color="transparent"
        color="black"
        grow
    >
      <v-tab
          v-for="item in items"
          :key="item"
      >
        {{ item }}
      </v-tab>
    </v-tabs>
    <v-tabs-items v-model="tab">
      <v-tab-item
          v-for="item in items"
          :key="item"
      >
        <v-card
            color="basil"
            flat
            v-if="item === 'Coffee'"
        >
          <CardGrid :events="events1" :buttonText="'Register'" @buttonClicked="eventHandler" />
        </v-card>

        <v-card
            color="basil"
            flat
            v-if="item === 'Frappuccino'"
        >
          <CardGrid :events="events2" :buttonText="'Register'" @buttonClicked="eventHandler" />
        </v-card>

        <v-card
            color="basil"
            flat
            v-if="item === 'Juice'"
        >
          <CardGrid :events="events3" :buttonText="'Register'" @buttonClicked="eventHandler" />
        </v-card>

        <v-card
            color="basil"
            flat
            v-if="item === 'Tea'"
        >
          <CardGrid :events="events4" :buttonText="'Register'" @buttonClicked="eventHandler" />
        </v-card>
      </v-tab-item>
    </v-tabs-items>
  </v-card>
</template>

<script>
import CardGrid from "@/components/Card/CardGrid";
export default {
  name: "Menu",
  components: {
    CardGrid
  },
  data () {
    return {
      tab: null,

      items: [
        'Coffee', 'Frappuccino', 'Juice', 'Tea'
      ],
      events1: [
        {
          name: "아메리카노",
          date: "4100",
          description:
              "강렬한 에스프레소 샷에 뜨거운 물의 조화",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[110563]_20150813222100205.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[110563]_20150813222100205.jpg",
          details: {
            "Team Size": "2",
            Time: "10AM - 1PM"
          }
        },
        {
          name: "콜드브루",
          date: "October 11, 2019",
          description:
              "바리스타의 정성으로 탄생한 콜드 브루! " +
              "콜드 브루 전용 원두를 차가운 물로 14시간 동안 추출하여 한정된 양만 제공됩니다." +
              "깊은 풍미의 새로운 커피 경험을 즐겨보세요.",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2016/04/[9200000000038]_20160408135802583.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2016/04/[9200000000038]_20160408135802583.jpg",
          details: {
            "Team Size": "2",
            Time: "12PM - 8PM"
          }
        },
        {
          name: "카페라떼",
          date: "October 12, 2019",
          description:
              "에스프레소 샷과 따뜻한 우유와 거품으로 마무리된 음료.",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[41]_20150813221357067.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[41]_20150813221357067.jpg",
          details: {
            "Team Size": "2",
            Time: "4PM - 6PM"
          }
        },
        {
          name: "바닐라 빈 라떼",
          date: "October 13, 2019",
          description:
              "프리미엄 바닐라 빈 시럽이 부드럽게 어우러진 카페 라떼",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2018/12/[9200000001939]_20181224154736071.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2018/12/[9200000001939]_20181224154736071.jpg",
          details: {
            "Team Size": "2",
            Time: "3PM - 5PM"
          }
        },
        {
          name: "카라멜 마끼야또",
          date: "October 13, 2019",
          description:
              "바닐라 시럽과 우유, 그리고 그 위에 얹어진 에스프레소 샷과 달콤한 카라멜 드리즐의 조화",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[126197]_20150813215717145.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[126197]_20150813215717145.jpg",
          details: {
            "Team Size": "2",
            Time: "3PM - 5PM"
          }
        },
        {
          name: "카푸치노",
          date: "October 13, 2019",
          description:
              "벨벳같은 우유 거품과 에스프레소 샷의 절묘한 조화!",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[38]_20150821164230205.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[38]_20150821164230205.jpg",
          details: {
            "Team Size": "2",
            Time: "3PM - 5PM"
          }
        },
        {
          name: "바닐라 플랫 화이트",
          date: "October 13, 2019",
          description:
              "리스트레토 샷과 향긋한 바닐라 풍미가 더해진 진하고 달콤한 음료",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2019/09/[9200000002406]_20190917152957175.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2019/09/[9200000002406]_20190917152957175.jpg",
          details: {
            "Team Size": "2",
            Time: "3PM - 5PM"
          }
        },
        {
          name: "에스프레소",
          date: "October 13, 2019",
          description:
              "강렬하고 카라멜향이 달콤한 음료",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[20]_20150813221922860.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[20]_20150813221922860.jpg",
          details: {
            "Team Size": "2",
            Time: "3PM - 5PM"
          }
        }
      ],
      events2: [
        {
          name: "카라멜 프라푸치노",
          date: "October 11, 2019",
          description:
              "카라멜 시럽이 더해진 커피 프라푸치노에 휘핑 크림, 카라멜이 장식된 음료." +
              "라이트 프라푸치노용 시럽 선택 가능-Tall 사이즈 기준, 25% 이상 줄어든 저당(Low Sugar)으로 즐기실 수 있습니다.",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[168010]_20150813220355957.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[168010]_20150813220355957.jpg",
          details: {
            "Team Size": "2",
            Time: "10AM - 1PM"
          }
        },
        {
          name: "바닐라 크림 프라푸치노",
          date: "October 11, 2019",
          description:
              "우유에 바닐라향이 조합된 아이스 블렌드로 휘핑크림이 토핑된 음료.",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[168054]_20150813220927225.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[168054]_20150813220927225.jpg",
          details: {
            "Team Size": "2",
            Time: "12PM - 8PM"
          }
        },
        {
          name: "자바 칩 프라푸치노",
          date: "October 12, 2019",
          description:
              "커피 프라푸치노에 초콜릿, 초콜릿 칩이 첨가된 아이스 블렌드로 달콤 아삭한 음료.",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[168016]_20150813231001795.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[168016]_20150813231001795.jpg",
          details: {
            "Team Size": "2",
            Time: "4PM - 6PM"
          }
        },
        {
          name: "에스프레소 프라푸치노",
          date: "October 13, 2019",
          description:
              "에스프레소의 강렬함과 약간의 단맛을 시원하게 즐기는 프라푸치노.",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[168007]_20150813222212580.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[168007]_20150813222212580.jpg",
          details: {
            "Team Size": "2",
            Time: "3PM - 5PM"
          }
        },
        {
          name: "모카 프라푸치노",
          date: "October 13, 2019",
          description:
              "초콜릿, 커피와 얼음이 갈린 음료에 휘핑크림이 토핑된 음료.",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[168004]_20150813221231839.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[168004]_20150813221231839.jpg",
          details: {
            "Team Size": "2",
            Time: "3PM - 5PM"
          }
        },
        {
          name: "초콜릿 크림 칩 프라푸치노",
          date: "October 13, 2019",
          description:
              "모카시럽과 자바칩이 혼합된 크림 프라푸치노로 휘핑크림, 초콜렛 드리즐된 음료.",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[168066]_20150806163214398.jpg",
          innerImage: "ahttps://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[168066]_20150806163214398.jpg",
          details: {
            "Team Size": "2",
            Time: "3PM - 5PM"
          }
        }
      ],
      events3: [
        {
          name: "수박주스",
          date: "October 11, 2019",
          description:
              "수박의 시원함과 달콤함이 풍성하게 느껴지는 주스",

          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2019/06/[9300000002115]_20190626101440361.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2019/06/[9300000002115]_20190626101440361.jpg",
          details: {
            "Team Size": "2",
            Time: "10AM - 1PM"
          }
        },
        {
          name: "망고주스",
          date: "October 11, 2019",
          description:
              "노랗게 익은 열대과일 망고가 입안 가득 느껴지는 주스",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2019/06/[5210008061]_20190627152423110.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2019/06/[5210008061]_20190627152423110.jpg",
          details: {
            "Team Size": "2",
            Time: "12PM - 8PM"
          }
        },
        {
          name: "딸기주스",
          date: "October 12, 2019",
          description:
              "달콤한 국내산 딸기의 과육이 듬뿍 느껴지는 주스",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2019/06/[5210008070]_20190627152902132.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2019/06/[5210008070]_20190627152902132.jpg",
          details: {
            "Team Size": "2",
            Time: "4PM - 6PM"
          }
        },
        {
          name: "토마토주스",
          date: "October 13, 2019",
          description:
              "국내산 토마토의 풍성한 과육이 듬뿍 담겨있는 주스",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2019/06/[5210008074]_20190627153254154.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2019/06/[5210008074]_20190627153254154.jpg",
          details: {
            "Team Size": "2",
            Time: "3PM - 5PM"
          }
        },
        {
          name: "케일&사과주스",
          date: "October 13, 2019",
          description:
              "국내산 케일과 사과의 달콤함이 조화로운 녹색 주스",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2019/06/[5210008072]_20190627153051152.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2019/06/[5210008072]_20190627153051152.jpg",
          details: {
            "Team Size": "2",
            Time: "3PM - 5PM"
          }
        },
        {
          name: "햇사과 주스",
          date: "October 13, 2019",
          description:
              "햇사과 1개 반을 껍질 그대로 착즙한 사과 주스.\n" +
              "달콤새콤한 사과 주스를 신선하게 즐겨 보세요.",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2019/12/[9300000002565]_20191205134634839.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2019/12/[9300000002565]_20191205134634839.jpg",
          details: {
            "Team Size": "2",
            Time: "3PM - 5PM"
          }
        }

      ],
      events4: [
        {
          name: "유자 민트 티",
          date: "October 11, 2019",
          description:
              "달콤한 유자와 알싸하고 은은한 진저,\n" +
              "우릴 수록 상쾌한 민트 티가 조화로운 유자 민트 티입니다.",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2020/06/[9200000002956]_20200616103415670.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2020/06/[9200000002956]_20200616103415670.jpg",
          details: {
            "Team Size": "2",
            Time: "10AM - 1PM"
          }
        },
        {
          name: "캐모마일 블렌드 티",
          date: "October 11, 2019",
          description:
              "캐모마일과 라벤더의 부드러운 꽃향이 어우러진 허브 티 입니다.",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2016/09/[4004000000076]_20160905102720278.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2016/09/[4004000000076]_20160905102720278.jpg",
          details: {
            "Team Size": "2",
            Time: "12PM - 8PM"
          }
        },
        {
          name: "자몽 허니 블랙 티",
          date: "October 12, 2019",
          description:
              "새콤달콤한 자몽과 꿀이 깊고 그윽한 풍미의 티바나의 블랙 티와 만났습니다. 화려한 색감과 톡 쏘는 상큼함이 더해진 티 음료입니다.",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2016/08/[9200000000187]_20160831101015864.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2016/08/[9200000000187]_20160831101015864.jpg",
          details: {
            "Team Size": "2",
            Time: "4PM - 6PM"
          }
        },
        {
          name: "허니 얼 그레이 밀크 티",
          date: "October 13, 2019",
          description:
              "베로가못 향 가득한 진한 티바나 얼 그레이 티에\n" +
              "꿀이 더해져 달콤하고 부드러운 밀크 티",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2020/09/[9200000003233]_20200911143800286.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2020/09/[9200000003233]_20200911143800286.jpg",
          details: {
            "Team Size": "2",
            Time: "3PM - 5PM"
          }
        },
        {
          name: "잉글리쉬 브렉퍼스트 티",
          date: "October 13, 2019",
          description:
              "인도 아삼, 스리랑카 실론, 중국의 홍차가 블렌딩 된 깊고 그윽한 블랙 티 입니다.",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2016/09/[4004000000016]_20160905101803555.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2016/09/[4004000000016]_20160905101803555.jpg",
          details: {
            "Team Size": "2",
            Time: "3PM - 5PM"
          }
        },
        {
          name: "민트 블렌드 티",
          date: "October 13, 2019",
          description:
              "스피어민트, 페퍼민트, 레몬버베나가 블렌딩된 상쾌한 허브 티 입니다.",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2016/09/[4004000000056]_20160905095218258.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2016/09/[4004000000056]_20160905095218258.jpg",
          details: {
            "Team Size": "2",
            Time: "3PM - 5PM"
          }
        },
        {
          name: "라임 패션 티",
          date: "October 13, 2019",
          description:
              "새콤달콤한 히비스커스와 라임의\n" +
              "이국적인 조화가 매력적인 라임 패션 티를 만나보세요!",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2019/01/[9200000001931]_20190114160428938.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2019/01/[9200000001931]_20190114160428938.jpg",
          details: {
            "Team Size": "2",
            Time: "3PM - 5PM"
          }
        }
      ],
      methods: {
        eventHandler() {
          console.log('button clicked');
        }
      }
    }
  }
}
</script>

<style scoped>
.basil {
  background-color: #FFFBE6;
}
.basil--text {
  color: #356859;
}

#hoi {
  display: flex;
  padding: 0 24px 0 24px;
  left: 600px;
  font-size: 22px;
  color: #356859;
  border-radius: 5px;
  font-weight: bold;
}
@media only screen and (max-width: 768px) {
  .title {
    font-size: 10vw;
  }
}

div.card {
  margin: 40px 40px;
}

</style>
