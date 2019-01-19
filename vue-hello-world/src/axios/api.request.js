import config from 'index'
const baseUrl = process.env.NODE_ENV === 'development' ? config.baseUrl.dev : config.baseUrl.pro

const axios = axios.create({
    baseURL: baseUrl,  // api的base_url
    timeout: 5000  // 请求超时时间
});
export default axios
