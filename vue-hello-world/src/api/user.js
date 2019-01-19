import HttpRequest from '@/axios/api.request'

export const getMessage = () => {
  return HttpRequest.request({
    url: 'message/',
    method: 'get'
  })
}

