const el = id => document.getElementById(id);
const log = msg => {
  const d = el('log');
  d.textContent = `${new Date().toLocaleTimeString()} — ${msg}\n` + d.textContent;
};

async function callApi(op, a, b) {
  let url;
  if (['sqrt','log','factorial'].includes(op)) {
    url = `/api/${op}?a=${encodeURIComponent(a)}`; // factorial expects 'n' param; we'll handle below
    if (op === 'factorial') url = `/api/${op}?n=${parseInt(a)}`;
  } else {
    url = `/api/${op}?a=${encodeURIComponent(a)}&b=${encodeURIComponent(b)}`;
  }

  const res = await fetch(url);
  if (!res.ok) {
    const text = await res.text();
    throw new Error(`Status ${res.status}: ${text}`);
  }
  return res.json();
}

document.getElementById('go').addEventListener('click', async () => {
  const a = el('a').value;
  const b = el('b').value;
  const op = el('op').value;
  try {
    log(`Calling ${op} with a=${a} b=${b}`);
    const data = await callApi(op, a, b);
    el('result').textContent = data;
    log(`Result: ${data}`);
  } catch (e) {
    el('result').textContent = 'Error';
    log('Error: ' + e.message);
  }
});
