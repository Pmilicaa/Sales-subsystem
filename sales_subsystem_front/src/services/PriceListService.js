import axios from "axios";

export const getAllPrices = async () => {
  const res = await axios.get('http://localhost:8080/priceLists')
  return res.data;
}
export const addPriceListItem = async (id, price) => {
  const item = {
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
export const addPriceList = async (articlePriceList) => {

  return await axios
    .post(`http://localhost:8080/priceLists`,
      { articlePriceList }
    )
    .then(response => {
      return response.data;
    });
}
export const addCopyOfPriceLIst = async (priceList) => {

  return await axios
    .post(`http://localhost:8080/priceLists/pdv`,
      priceList
    )
    .then(response => {
      return response.data;
    });
}
export const getPriceList = async (id) => {

  return await axios
    .get(`http://localhost:8080/priceLists/${id}`
    )
    .then(response => {
      return response.data;
    });
}