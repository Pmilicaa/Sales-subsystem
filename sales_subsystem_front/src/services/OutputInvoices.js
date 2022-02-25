import axios from "axios";

const baseEndpointUrl = "http://localhost:8080";

export const getAllOutputInvoices = async () => {
  const res = await axios.get(`${baseEndpointUrl}/outputInvoices`)
  return res.data;
}
export const addOutputInvoice = async (article) => {
  return await axios
    .post(`${baseEndpointUrl}/outputInvoices`,
      article
    )
    .then(response => {
      return response.data;
    });
}