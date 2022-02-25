const OutputInvoice = (props) => {
  return (
    <>
      {
        <tbody>
          <tr>
            <td>{props.invoice.numberAccount}</td>
            <td>{props.invoice.totalBase}</td>
            <td>{props.invoice.totalPDV}</td>
            <td>{props.invoice.totalPayment}</td>
            <td>{props.invoice.releaseDate}</td>
          </tr>
        </tbody>
      }
    </>
  );
}
export default OutputInvoice;



