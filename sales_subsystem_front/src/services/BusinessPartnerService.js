import axios from "axios";
var endpointBaseUrl = "http://localhost:8080"
export const getAllBusinessPartners = async () => {
  const res = await axios.get(`${endpointBaseUrl}/businesspartners`)
  return res.data
}

export const addBusinessPartner = async (partner) => {
  return await axios
  .post(`${endpointBaseUrl}/businesspartners`, partner)
  .then(res => { return res.data})
}