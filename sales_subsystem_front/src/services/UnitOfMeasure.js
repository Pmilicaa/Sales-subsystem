import axios from "axios";

export const getAllUnitOfMeasures = async () => {
   const res = await axios.get('http://localhost:8080/unitOfMeasures')
   return res.data;
}