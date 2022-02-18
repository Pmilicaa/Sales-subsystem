import axios from "axios";

export const getAllPrices =async ()=>{
   const res = await axios.get('http://localhost:8080/priceLists')
   console.log(res)
   return res.data;
}