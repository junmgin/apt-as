<template>

    <v-card outlined>
        <v-card-title>
            Mypage # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="DefectId" v-model="item.defectId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="DefectType" v-model="item.defectType" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Status" v-model="item.status" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Qty" v-model="item.qty" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'MypageViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/mypages/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

