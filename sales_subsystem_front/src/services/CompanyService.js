import axios from "axios";

const endpointBaseUrl = "http://localhost:8080/companies"

export const getAllCompanies =async ()=>{
   const res = await axios.get(endpointBaseUrl)
   return res.data;
}

export const addCompany = async (company) => {
   return axios
   .post(endpointBaseUrl, company)
   .then(res => { return res.data })
   .catch(error => { return error })
}