import axios from "axios";

export const getAllCompanies =async ()=>{
   const res = await axios.get('http://localhost:8080/companies')
   // console.log(res.data)
   return res.data;
}