import axios from "axios";

const baseUrl = "http://localhost:8080/outputInvoices";

export const getAllOutputInvoices =async ()=>{
    const res = await axios.get('http://localhost:8080/outputInvoices')
    console.log(res.data)
    return res.data;
}
export const addOutputInvoice =async (article)=>{
    return await axios
    .post('http://localhost:8080/outputInvoices/', 
    article
    )
    .then(response => {
      return response.data;
    });
}