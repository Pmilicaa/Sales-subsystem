import axios from "axios";

export const getAllPrices =async ()=>{
   const res = await axios.get('http://localhost:8080/priceLists')
   console.log(res)
   return res.data;
}
export const addPriceList =async (article,priceList)=>{
   
    return await axios
    .post(`http://localhost:8080/articles/${article.id}/priceList`, 
      priceList
    )
    .then(response => {
      return response.data;
    });
 }