<template>
    <div class="container">
        <div class="flex flex-wrap">
            <div
                v-for="frpcConfigItem in frpcConfigItems"
                :key="frpcConfigItem.name"
                class="frpc-config-item"
            >
                <el-card class="box-card">
                    <div slot="header" class="clearfix">
                        <span>{{ frpcConfigItem.name }}</span>
                    </div>
                    <div
                        v-for="entry in frpcConfigItem.values"
                        :key="entry.key"
                        class="text item"
                    >
                        {{ entry.key }} - {{ entry.value }}
                    </div>
                </el-card>
            </div>
        </div>
    </div>
</template>
<script>
import script from './script.js'
export default script
</script>

<style lang="scss" src="./style.scss"></style>
