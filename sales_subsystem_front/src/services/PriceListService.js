import axios from "axios";

export const getAllPrices =async ()=>{
   const res = await axios.get('http://localhost:8080/priceLists')
   console.log(res)
   return res.data;
}
export const addPriceList =async (id,price)=>{
    console.log(price);
    const item={
      id,
      price
    }
    return await axios
    .post(`http://localhost:8080/priceListItems`, 
      item
    )
    .then(response => {
      return response.data;
    });
 }