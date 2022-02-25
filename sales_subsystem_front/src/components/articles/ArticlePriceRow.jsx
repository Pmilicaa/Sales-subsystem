const ArticlePriceRow = ({ article }) => {
  return (
    <>
      <tbody>
        <tr>
          <td>{article.name}</td>
          <td>{article.description}</td>
          <td>{article.priceListItem.price}</td>
          {article.unitOfMeasure.shortName && <td>{article.unitOfMeasure.shortName}</td>}
          <td>{article.articleGroup.name}</td>
        </tr>
      </tbody>
    </>
  )
}
export default ArticlePriceRow;