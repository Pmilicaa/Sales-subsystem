import { Button } from "react-bootstrap";
import { formatMillis } from "../../utils/time";
import { useNavigate } from "react-router-dom";

const OutputInvoice = ({ invoice }) => {
  const navigate = useNavigate();
  
  return (
    <tr>
      <td>{invoice.numberAccount}</td>
      <td>{invoice.totalBase}</td>
      <td>{invoice.totalPDV}</td>
      <td>{invoice.totalPayment}</td>
      <td>{formatMillis(invoice.releaseDate)}</td>
      <td><Button onClick={()=> navigate(`/invoiceDetails/${invoice.id}`)}>View invoice details</Button></td>
    </tr>
  );
}
export default OutputInvoice;



