import axios from "axios";

const baseUrl = "http://localhost:8080/invoiceItems"

export const getAllInvoices = async () => {
  const res = await axios.get(baseUrl)
  return res.data;
}
export const addInvoice = async (name, description, price, uom, group, pib) => {
  let article = {
    name,
    description,
    price,
    uom,
    group,
    pib
  }

  return await axios
    .post(baseUrl,
      article
    )
    .then(response => {
      return response.data;
    });
}