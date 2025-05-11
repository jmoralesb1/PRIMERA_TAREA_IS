import { Link } from 'react-router-dom';

function Navbar() {
  return (
    <nav>
      <ul>
        <li><Link to="/entrada">Entrada</Link></li>
        <li><Link to="/salida">Salida</Link></li>
        <li><Link to="/celdas">Estado de Celdas</Link></li> {/* Nueva opción */}
      </ul>
    </nav>
  );
}

export default Navbar;
