import axios from "axios";

export const getAllArticles =async ()=>{
   const res = await axios.get('http://localhost:8080/articles')
   console.log(res)
   return res.data;
}