import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Entrada from './pages/Entrada';
import Salida from './pages/Salida';
import EstadoCeldas from './pages/EstadoCeldas';
import './App.css'; // Importa el archivo CSS

function App() {
  return (
    <Router>
      <div className="p-4">
        <h1 className="text-3xl font-bold mb-4">IU Parking</h1>
        <nav className="mb-4 nav-links">
          <Link to="/entrada" className="nav-link">Registrar Entrada</Link>
          <Link to="/salida" className="nav-link">Registrar Salida</Link>
          <Link to="/celdas" className="nav-link">Estado de Celdas</Link>
        </nav>
        <Routes>
          <Route path="/entrada" element={<Entrada />} />
          <Route path="/salida" element={<Salida />} />
          <Route path="/celdas" element={<EstadoCeldas />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;