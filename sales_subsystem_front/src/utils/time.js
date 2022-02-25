export function formatMillis(millis) {
  var options = { weekday: 'short', year: 'numeric', month: 'short', day: 'numeric', hour: 'numeric', minute: 'numeric' };
  return (new Date(millis).toLocaleDateString('en-US', options));
}