<template>
  <div>
    <!--Stats cards-->
    <div class="row">
      <div
        class="col-md-6 col-xl-3"
        v-for="stats in statsCards"
        :key="stats.title"
      >
        <stats-card>
          <div
            class="icon-big text-center"
            :class="`icon-${stats.type}`"
            slot="header"
          >
            <i :class="stats.icon"></i>
          </div>
          <div class="numbers" slot="content">
            <p>{{ stats.title }}</p>
            {{ stats.value }}
          </div>
          <div class="stats" slot="footer">
            <i :class="stats.footerIcon"></i> {{ stats.footerText }}
          </div>
        </stats-card>
      </div>
    </div>

    <!--Charts-->
    <div class="row">
      <div class="col-12">
        <chart-card
          title="장단기 금리차 차트"
          sub-title="Treasury Constant Maturity Chart"
          :chart-data="usersChart.data"
          :chart-options="usersChart.options"
        >
          <span slot="footer">
            <i class="ti-reload"></i> Updated 3 minutes ago
          </span>
          <div slot="legend">
            <i class="fa fa-circle text-info"></i> 10Y - 2Y
            <i class="fa fa-circle text-danger"></i> 10Y - 10Y_TYPS
            <i class="fa fa-circle text-warning"></i> 10Y - 3M 
          </div>
        </chart-card>
      </div>

      <div class="col-md-6 col-12">
        <chart-card
          title="Email Statistics"
          sub-title="Last campaign performance"
          :chart-data="preferencesChart.data"
          chart-type="Pie"
        >
          <span slot="footer">
            <i class="ti-timer"></i> Campaign set 2 days ago</span
          >
          <div slot="legend">
            <i class="fa fa-circle text-info"></i> Open
            <i class="fa fa-circle text-danger"></i> Bounce
            <i class="fa fa-circle text-warning"></i> Unsubscribe
          </div>
        </chart-card>
      </div>

      <div class="col-md-6 col-12">
        <chart-card
          title="2015 Sales"
          sub-title="All products including Taxes"
          :chart-data="activityChart.data"
          :chart-options="activityChart.options"
        >
          <span slot="footer">
            <i class="ti-check"></i> Data information certified
          </span>
          <div slot="legend">
            <i class="fa fa-circle text-info"></i> Tesla Model S
            <i class="fa fa-circle text-warning"></i> BMW 5 Series
          </div>
        </chart-card>
      </div>
    </div>
  </div>
</template>
<script>
import { StatsCard, ChartCard } from "@/components/index";
import Chartist from "chartist";
import axios from "axios";
export default {
  components: {
    StatsCard,
    ChartCard,
  },
  /**
   * Chart data used to render stats, charts. Should be replaced with server data
   */
  data() {
    return {
      statsCards: [
        {
          type: "warning",
          icon: "ti-image",
          title: "Fear and Greed Index",
          value: "0",
          footerText: "Updated now",
          footerIcon: "ti-calendar",
        },
        {
          type: "success",
          icon: "ti-money",
          title: "장단기 금리차\n10Y - 2Y",
          value: "0",
          footerText: "Last day",
          footerIcon: "ti-calendar",
        },
        {
          type: "danger",
          icon: "ti-money",
          title: "장단기 금리차\n10Y - 3M",
          value: "0",
          footerText: "In the last hour",
          footerIcon: "ti-calendar",
        },
        {
          type: "info",
          icon: "ti-stats-up",
          title: "expected inflation",
          value: "0",
          footerText: "Updated now",
          footerIcon: "ti-calendar",
        },
      ],
      usersChart: {
        data: {
          labels: [
          ],
          series: [
            [],
            [],
            [],
          ],
        },
        options: {
          low: -3,
          high: 3,
          showArea: false,
          height: "245px",
          axisX: {
            showGrid: false,
          },
          lineSmooth: Chartist.Interpolation.simple({
            divisor: 3,
          }),
          showLine: true,
          showPoint: false,
        },
      },
      activityChart: {
        data: {
          labels: [
            "Jan",
            "Feb",
            "Mar",
            "Apr",
            "Mai",
            "Jun",
            "Jul",
            "Aug",
            "Sep",
            "Oct",
            "Nov",
            "Dec",
          ],
          series: [
            [542, 543, 520, 680, 653, 753, 326, 434, 568, 610, 756, 895],
            [230, 293, 380, 480, 503, 553, 600, 664, 698, 710, 736, 795],
          ],
        },
        options: {
          seriesBarDistance: 10,
          axisX: {
            showGrid: false,
          },
          height: "245px",
        },
      },
      preferencesChart: {
        data: {
          labels: ["62%", "32%", "6%"],
          series: [62, 32, 6],
        },
        options: {},
      },
    };
  },
  mounted(){
    this.getFearGreed();
    this.getYield();
    this.getAllYield();
  },
  methods: {
    getFearGreed() {
      axios
        .get(`/open-api/invest_ref/recent_fear_greed`)
        .then((result) => {
          this.statsCards[0].value = result.data.body.value;
          this.statsCards[0].footerText = result.data.body.date;
          console.log(result.data);
        })
        .catch((error) => {
          console.log(error);
        })
        .finally(() => {
          console.log("finally");
        });
    },
    getYield() {
      axios
        .get(`/open-api/invest_ref/recent_yield`)
        .then((result) => {
          this.statsCards[1].value = result.data.body.t10y2y;
          this.statsCards[1].footerText = result.data.body.date;
          this.statsCards[2].value = result.data.body.t10y3m;
          this.statsCards[2].footerText = result.data.body.date;
          this.statsCards[3].value = result.data.body.t10yie;
          this.statsCards[3].footerText = result.data.body.date;
          console.log(result.data);
        })
        .catch((error) => {
          console.log(error);
        })
        .finally(() => {
          console.log("finally");
        });
    },
    getAllYield() {
      axios
        .get(`/open-api/invest_ref/all_yield`)
        .then((result) => {
          for(let i = 0; i < result.data.body.length; i++){
            if(i % 100 == 0){
              this.usersChart.data.labels.push(result.data.body[i].date);
            } else {
              this.usersChart.data.labels.push("");
            }
            this.usersChart.data.series[0].push(result.data.body[i].t10y2y);
            this.usersChart.data.series[1].push(result.data.body[i].t10y3m);
            this.usersChart.data.series[2].push(result.data.body[i].t10yie);
          }
          console.log(result.data);
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
