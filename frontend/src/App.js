import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Entrada from './pages/Entrada';
import Salida from './pages/Salida';
import EstadoCeldas from './pages/EstadoCeldas';

function App() {
  return (
    <Router>
      <div className="p-4">
        <h1 className="text-3xl font-bold mb-4">IU Parking</h1>
        <nav className="mb-4">
          <Link to="/entrada" className="mr-4">Registrar Entrada</Link>
          <Link to="/salida" className="mr-4">Registrar Salida</Link>
          <Link to="/celdas">Estado de Celdas</Link> {/* Nueva ruta */}
        </nav>
        <Routes>
          <Route path="/entrada" element={<Entrada />} />
          <Route path="/salida" element={<Salida />} />
          <Route path="/celdas" element={<EstadoCeldas />} /> {/* Nueva vista */}
        </Routes>
      </div>
    </Router>
  );
}

export default App;

