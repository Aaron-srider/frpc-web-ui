import request from '@/utils/request'

export function fetchAllFrpcConfigItems(query) {
    return request({
        url: '/frpc/configs',
        method: 'get',
        params: query
    })
}
