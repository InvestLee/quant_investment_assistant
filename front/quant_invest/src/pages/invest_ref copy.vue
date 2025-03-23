<template>
  <div>
    <button @click="getFearGreed">데이터 가져오기</button>
    <div>{{ dataGreed }}</div>
  </div>
</template>
 
<script>
import axios from "axios";
 
export default {
  name: "App",
  mounted(){
    this.getFearGreed();
  },
  data() {
    return {
      dataGreed: [],
      id: 1,
    };
  },
  methods: {
    getFearGreed() {
      axios
        .get(`http://localhost:8080/open-api/invest_ref/recent_fear_greed`)
        .then((result) => {
          console.log(result.data);
          this.dataGreed.push(result.data.body.value);
          this.dataGreed.push("|");
          this.dataGreed.push(result.data.body.date);
          this.id++;
        })
        .catch((error) => {
          console.log(error);
        })
        .finally(() => {
          console.log("finally");
        });
    },
  },
};
</script>
 
<style></style>