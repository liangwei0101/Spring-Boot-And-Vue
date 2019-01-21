import HttpRequest from '@/axios/api.request'

export const UserQryAction = () => {
  return HttpRequest.request({
    url: 'user/',
    method: 'get'
  })
}

export const UserAddAction = (parameter) => {
  return HttpRequest.request({
    url: 'user/',
    method: 'post',
    params: parameter
  })
}

export const UserUpdateAction = () => {
  return HttpRequest.request({
    url: 'user/',
    method: 'put'
  })
}

export const UserDelAction = () => {
  return HttpRequest.request({
    url: 'user/',
    method: 'delete'
  })
}

