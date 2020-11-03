<template>
  <div>
    메뉴 이름<input type="text" v-model="drinkName"/><br/>
    메뉴 타입<input type="text"v-model="drinkType"/><br/>
    메뉴 가격<input type="text" v-model="drinkPrice"/><br/>
    <file-pond
      name="fileinput"
      ref="pond"
      allow-multiple="false"
      max-files="1"
      accepted-file-types="image/*"
      :server="server"
    />
    <input type="text"/>
    <v-textarea
      no-resize
      outlined
      rows="10"
      v-model="drinkMemo"/>
  </div>
</template>

<script>
import 'filepond/dist/filepond.min.css'
//  아이디 저장 -> 빼오기
export default {
  name:'AddMenu',
  components: {
  },
  data () {
    return {
      server: {
        url: 'http://localhost:1234/menus/file',
        process: {
          url: '/file',
          method: 'POST',
          data: id
        },
        revert: {
          url: '/fileremove',
          method: 'POST'
        }
      }
    }
  },
  computed: {
  },
  methods: {
  },
  mounted() {
  }
}
</script>