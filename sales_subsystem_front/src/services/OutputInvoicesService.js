import axios from "axios";

const baseUrl = "http://localhost:8080";

export const getAllOutputInvoices = async () => {
  const res = await axios.get(`${baseUrl}/outputInvoices`)
  return res.data;
}

export const getOutputInvoiceById = async (id) => {
  const res = await axios.get(`${baseUrl}/outputInvoices/${id}`)
  return res.data;
}

export const addOutputInvoice = async (article) => {
  return await axios
    .post(`${baseUrl}/outputInvoices`,
      article
    )
    .then(response => {
      return response.data;
    });
}