
import * as frpcApi from '@/api/frpc'
export default {
    components: {},
    data() {
        return {
            frpcConfigItems: [
                {
                    name: 'common',
                    values: [
                        {
                            key: 'token',
                            value: 'wc123222'
                        },
                        {
                            key: 'port',
                            value: '45234'
                        }
                    ]
                },
                {
                    name: 'ssh',
                    values: [
                        {
                            key: 'token',
                            value: 'wc123456'
                        },
                        {
                            key: 'port',
                            value: '22'
                        }
                    ]
                },
                {
                    name: 'java',
                    values: [
                        {
                            key: 'token',
                            value: 'wc123456'
                        },
                        {
                            key: 'port',
                            value: '22'
                        }
                    ]
                },
                {
                    name: 'php',
                    values: [
                        {
                            key: 'token',
                            value: 'wc123456'
                        },
                        {
                            key: 'port',
                            value: '22'
                        }
                    ]
                }
            ]
        }
    },
    computed: {},
    watch: {},
    created() {
        console.log('created')
        frpcApi.fetchAllFrpcConfigItems().then((resp) => {
            console.log(resp)
            // console.log(resp.data.data.name)
            // const configs =
            this.frpcConfigItems = resp.data
        })
    },
    mounted() {},
    beforeCreate() {},
    beforeMount() {},
    beforeUpdate() {},
    updated() {},
    beforeDestroy() {},
    destroyed() {},
    activated() {},
    methods: {
        last(frpcConfigItem, index) {
            // const total = this.frpcConfigItems.length
            console.log(index)
            const oneRowCount = 3
            console.log((index + 1) % oneRowCount === 0)
            return (index + 1) % oneRowCount === 0
        }
    }
}
