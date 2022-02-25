import axios from "axios";

export const getAllArticles = async () => {
  const res = await axios.get('http://localhost:8080/articles')
  return res.data;
}
export const addArticle = async (name, description, price, uom, group, pib) => {
  let article = {
    name,
    description,
    price,
    uom,
    group,
    pib
  }

  return await axios
    .post('http://localhost:8080/articles/',
      article
    )
    .then(response => {
      return response.data;
    });
}